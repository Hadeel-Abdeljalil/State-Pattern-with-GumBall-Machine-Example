package statepatternexample;

import ConcreteState.HasQuarterState;
import ConcreteState.NoQuarterState;
import ConcreteState.SoldOutState;
import ConcreteState.SoldState;

/**
 *
 * @author h02ad
 */
//Context
public class GumballMachine {
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    
    State state = soldOutState;
    int count = 0;
    
    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        
        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        }
    }
    
    public void insertQuarter() {
        state.insertQuarter();
    }
    
    public void ejectQuarter() {
        state.ejectQuarter();
    }
    
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }
    
    public void setState(State state) {
        this.state = state;
    }
     public int getCount() {
        return count;
    }
    
    // Methods to get different states
    public State getSoldOutState() { return soldOutState; }
    public State getNoQuarterState() { return noQuarterState; }
    public State getHasQuarterState() { return hasQuarterState; }
    public State getSoldState() { return soldState; }
    
    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count--;
        }
    }
     // Main method to simulate the Gumball Machine
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);

        System.out.println("Initial state: " + gumballMachine.getCount() + " gumballs in the machine.");

        // Insert a quarter and turn the crank
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        // Insert another quarter and turn the crank
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        // Eject a quarter
        gumballMachine.ejectQuarter();

        // Turn crank without a quarter
        gumballMachine.turnCrank();

        // Refill the machine with more gumballs
        System.out.println("Refilling the machine with 2 more gumballs.");
        gumballMachine = new GumballMachine(7);

        // Insert a quarter and turn the crank again
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
    }
}
