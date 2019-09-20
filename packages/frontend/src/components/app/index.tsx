import React from "react";
import logo from "./logo.svg";

export const App = () => (
    <div className="rl-app">
        <div className="rl-app-card card text-white bg-dark border-info mb-3">
            <div className="row no-gutters">
                <div className="rl-app-card__image-wrapper col-md-4">
                    <img src={logo} className="rl-app-card__image card-img" alt="React Logo" />
                </div>
                <div className="col-md-8">
                    <div className="card-body">
                        <h5 className="card-title">Welcome to the React/Typescript Bootcamp!</h5>
                        <p className="card-text">
                            Start hacking by editing any Typescript or SCSS style file and saving it. Your changes will
                            be reflected immediately.
                        </p>
                        <p className="card-text">
                            Explore the (opinionated) project structure and familiarize yourself with the bootstrapped
                            codebase.
                        </p>
                        <p className="card-text">
                            <small className="text-muted">There are no mistakes, only opportunities!</small>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
);
