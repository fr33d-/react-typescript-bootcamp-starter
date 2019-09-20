# React/Typescript Bootcamp Starter Repository

> The Rusty Lobster Bootcamp - Creating Burgers with React and Typescript

This project serves as a basic start point for our React/Typescript training. It provides a bootstrapped frontend application and a fully-implemented backend application. So with this participants should be able to start hacking right away.

## Introduction

You have been hired to build a frontend based on cutting edge technology for the *Rusty Lobster*. So far, the backend developers have already created a fully-documented REST API which is at your disposal. In particular, you will develop a burger configurator wherein visitors of the site can create custom burgers and save them or just browse other saved burgers. Stories and tasks will be available in a backlog that you will have to work on with your new team.

The twist is the methodology with which you will be working during this training. It is meant to be a collaborative hands-on experience using mob programming wherein the entire team works on the same codebase at the same time at the same computer. Think of pair programming on steroids.

Over the course of the training you will explore various important topics and concepts such as the following:

* Basics of Typescript
* Stateless Functional Components
* Stateful Legacy Class Components
* Hooks
* Stateful Functional Components using Hooks
* Fetching REST APIs
* Routing
* User Authentication using JWT
* State Management using the React Context API
* Testing with Jest and the React Testing Library

## Requirements

For the training itself we require you to be familiar with the following topics:

* Working with yarn or npm in the Javascript ecosystem
* Intermediate knowledge of the following ES6 and ES2015 language features
    * [Arrow Functions](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/Arrow_functions)
    * [Rest Parameters](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/rest_parameters)
    * [Spread Syntax](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Spread_syntax)
    * [String Interpolation](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Template_literals)
    * [Property Shorthand](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Object_initializer#New_notations_in_ECMAScript_2015)
    * [Destructuring](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Destructuring_assignment)
    * [Export](https://developer.mozilla.org/en-US/docs/web/javascript/reference/statements/export)
    * [Import](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/import)
    * [Classes](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Classes)
    * [Promises](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise)
    * [Asynchronous programming using `async`](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/async_function)
    * [`await`ing results of `async` functions and Promises](https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Asynchronous/Async_await)

### Technical requirements

* Node 10.15.3
* Java 11
* Docker

We highly suggest using [SDKMAN](https://sdkman.io/) to install Java and Gradle as well as [NVM](https://github.com/nvm-sh/nvm) for installing Node.

## Training material

In the `documentation` folder you will find supplemental training material that contains short summaries of the most common topics and terminology you will encounter during the training. It is intended to give you a first look on specific topics but not in extraordinary detail. Trial and error with your team mates as well as googling will yield further information.

## Developing and debugging the application locally

TODO

## Running the production build locally

We have created a `docker-compose.yaml` file and it's corresponding `docker/backend.dockerfile` that will build a single Docker container for the entire application just by running

```
docker-compose up
```

and heading over to `http://localhost:8080/`. The backend is configured to serve the built frontend application on `/` while the REST API is exposed on multiple endpoints prefixed with `/api`.

## Notes

* The supplied `.vscode/settings.json` in the `master` branch intentionally contains a list of files and folder that are hidden in the file explorer of VS Code. We made this conscious decision to reduce noise by hiding configuration files and unrelated folders and scripts not related to the actual development during the training. These are the files and folders that are excluded from the explorer:

```json
{
    "files.exclude": {
        "**/node_modules": true,
        "**/build": true,
        ".*": true,
        "docker": true,
        "docker-compose.yaml": true,
        "lerna.json": true,
        "LICENSE": true,
        "tslint.json": true,
        "yarn.lock": true,
        "packages/backend": true,
        "packages/frontend/tsconfig.json": true,
        "packages/frontend/src/react-app-env.d.ts": true
    }
}
```

