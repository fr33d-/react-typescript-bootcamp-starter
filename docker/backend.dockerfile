###############################################################################
# Build Environment for Frontend
###############################################################################
FROM node:10-alpine as frontend-build-environment
ENV NODE_ENV development

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY packages/frontend/package.json yarn.lock ./
RUN yarn
COPY packages/frontend/ .
RUN yarn build

###############################################################################
# Build Environment for Backend
###############################################################################
FROM openjdk:11 as backend-build-environment

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

# Cache Gradle
COPY packages/backend/*.gradle packages/backend/gradlew ./
COPY packages/backend/gradle ./gradle
RUN ./gradlew --version

COPY packages/backend .
COPY --from=frontend-build-environment /usr/src/app/build ./src/main/resources/static/

RUN ./gradlew build

###############################################################################
# Production Environment
###############################################################################
FROM openjdk:11 as production-environment

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY --from=backend-build-environment /usr/src/app/build/libs/ .
RUN mv *.jar backend.jar

CMD [ "java", "-jar", "backend.jar" ]
