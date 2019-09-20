import { act, fireEvent, render } from "@testing-library/react";
import React from "react";
import ReactDOM from "react-dom";
import { App } from "..";

describe("App component", () => {
    it("renders without crashing", () => {
        const div = document.createElement("div");
        ReactDOM.render(<App />, div);
        ReactDOM.unmountComponentAtNode(div);
    });

    describe("style", () => {
        it("has the correct classes", () => {
            const { container } = render(<App />);
            const appWrapper = container.firstChild;
            expect(appWrapper).toBeInTheDocument();
            expect(appWrapper).toHaveClass("rl-app");
        });

        it("no longer has the header", () => {
            const { container } = render(<App />);
            const appHeader = container.querySelector(".rl-app-header");
            expect(appHeader).not.toBeInTheDocument();
        });
    });

    describe("behaviour", () => {
        it("still has the same root class after clicking it", () => {
            const { container } = render(<App />);
            const appWrapper = container.firstChild;
            act(() => {
                fireEvent.click(appWrapper as Element);
            });
            expect(appWrapper).toBeInTheDocument();
            expect(appWrapper).toHaveClass("rl-app");
        });
    });
});
