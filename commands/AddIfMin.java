package commands;

import collection.MyTreeSet;
import data.Ticket;
import processor.Processor;

public class AddIfMin extends AbstractCommand {
    private MyTreeSet myTreeSet;
    private Processor processor;

    public AddIfMin(String name, MyTreeSet myTreeSet, Processor processor) {
        super(name);
        this.processor = processor;
        this.myTreeSet = myTreeSet;
    }

    @Override
    public void execute() {
        Ticket ticket = processor.getTicket(myTreeSet);
        if (ticket != null) {
            if (myTreeSet.isMin(ticket)) {
                myTreeSet.add(ticket);
            } else {
                System.out.println("Element isn't maximal");
            }
        } else {
            System.out.println("Incorrect data in script");
        }
    }
}
