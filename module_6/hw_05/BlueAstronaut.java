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
            boolean isFrozenCheck1 = true;
            Arrays.sort(players);
            int susIndex = players.length - 1;
            System.out.println(susIndex);
            System.out.println(players[susIndex].getSusLevel());
            System.out.println(players[susIndex - 1].getSusLevel());
           
            while(isFrozenCheck1) {
                if (players[susIndex].isFrozen()) {
                    susIndex--;
                    System.out.println(players[susIndex].getName() + " : " + susIndex);
                } else {
                    isFrozenCheck1 = false;
                }
            }
           
            if (players[susIndex].getSusLevel() != players[susIndex - 1].getSusLevel()) {
                players[susIndex].setFrozen(true);
                // System.out.println(players[susIndex].getName() + " is most sus");
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