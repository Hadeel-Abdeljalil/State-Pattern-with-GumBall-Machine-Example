package statepatternexample;

public interface State {
    // define the general actions for the GumBall machine
    void insertQuarter();
    void turnCrank();
    void ejectQuarter();
    void dispense();
}
