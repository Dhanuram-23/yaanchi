document.addEventListener("DOMContentLoaded", () => {

    console.log("Yaanchii Fashion Store Loaded");

    const buttons = document.querySelectorAll(".btn");

    buttons.forEach(button => {

        button.addEventListener("mouseenter", () => {
            button.style.opacity = "0.9";
        });

        button.addEventListener("mouseleave", () => {
            button.style.opacity = "1";
        });

    });

});