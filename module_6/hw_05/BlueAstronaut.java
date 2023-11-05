import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
    
    protected int numTasks;
    protected int taskSpeed;

    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    public BlueAstronaut(String name) {
        super(name, 15); 
        this.numTasks = 6;
        this.taskSpeed = 10;
    }

    public void emergencyMeeting(Player[] players) {
        if(!this.isFrozen()){
            Arrays.sort(players);
            int susInt = players.length - 1;
            System.out.println(susInt);
            System.out.println(players[susInt].getSusLevel());
            System.out.println(players[susInt - 1].getSusLevel());
            for (Player p: players) {
                System.out.println(p.getName() + " : " + p.getSusLevel());
            }
            if (players[susInt].getSusLevel() != players[susInt - 1].getSusLevel()) {
                players[susInt].setFrozen(true);
                System.out.println(players[susInt].getName() + "is most sus");
            }   
            
            gameOver();
        }       
    }

    public void completeTask(){
        if (!isFrozen()) {
            int oldTasks = this.numTasks;
            
            if(taskSpeed > 20) {
                numTasks -= 2;
            } else {
                numTasks -= 1;
            }
            if (oldTasks > 0 && numTasks <=0) {
                System.out.println("I have completed all my tasks!");
                setSusLevel((getSusLevel()/2));
            }
        }

        if (numTasks <= 0) {
            numTasks = 0;
        }

    }
    
    public boolean equals(Object o) {
        if (o instanceof BlueAstronaut) {
            BlueAstronaut p = (BlueAstronaut) o;    
            if(super.equals(o)) {
                return this.numTasks == p.getNumTask() && this.taskSpeed == p.getTaskSpeed();
            }
        }

        return false;
    }

    @Override
    public String toString() {
        String baseString = (super.toString() + " I have " + this.numTasks + " left over.");
        if (this.getSusLevel() > 15) {
            return baseString.toUpperCase();
        } else {
            return baseString;
        }
    }

    public int getTaskSpeed() {
        return taskSpeed;
    }

    public int getNumTask() {
        return numTasks;
    }

}