Members: 
Mendoza, Elaine
Napiza, Sandy 
Rosales, Frederick


## Building the Project (No Terminal Required)

This project uses Maven, which needs to compile the source code before tests can run. If you're not comfortable using the terminal, you can do this entirely through VS Code:

1. Open the project folder in VS Code.
2. Make sure the **"Extension Pack for Java"** extension is installed (Extensions icon on the sidebar → search "Extension Pack for Java" → Install). This is a one-time setup.
3. Press **Ctrl+Shift+P** to open the Command Palette.
4. Type `Maven: Execute Commands...` and press Enter.
5. Select **compile** from the list to build the project, or **test** to build and run all tests.

This will automatically generate the `target/` folder needed to run the project — you don't need to create it manually or find it anywhere, and you don't need to use `mvn` in a terminal.

> Note: `target/` is intentionally excluded from this repo (see `.gitignore`) since it's regenerated automatically every time the project is built.