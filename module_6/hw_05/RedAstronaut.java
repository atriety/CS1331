import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
    
    private String skill;

    private final String DEFAULT_SKILL = "experienced";
    private final int DEFAULT_SUSLEVEL = 15;

    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill;
    }
    
    public RedAstronaut(String name) {
        super(name, 15);
        this.skill = DEFAULT_SKILL;
    }

    public void emergencyMeeting() {
        Player[] p = getPlayers();
        if(!this.isFrozen()){
            boolean isFrozenCheck1 = true;
            Arrays.sort(p);
            int susIndex = p.length - 1;

            while(isFrozenCheck1) {
                if (p[susIndex].isFrozen()) {
                    susIndex--;
                }
                isFrozenCheck1 = false;
            }
            if (this.equals(p[susIndex])) {
                if (p[susIndex - 1].getSusLevel() != p[susIndex - 2].getSusLevel()) {
                    p[susIndex - 1].setFrozen(true);
                } 
            } else {
                if (p[susIndex].getSusLevel() != p[susIndex - 1].getSusLevel()) {
                    p[susIndex].setFrozen(true);
                }          
            }
            gameOver();  
        }
    }

    public void freeze(Player p) {
        if(p instanceof Impostor || this.isFrozen() || p.isFrozen()) {}
        else{
            if (this.getSusLevel() < p.getSusLevel()) {
                p.setFrozen(true);
            } else {
                this.setSusLevel((this.getSusLevel()*2));
            }
            gameOver();
        }
    }

    public void sabotage(Player p) {
        if(p instanceof Impostor || this.isFrozen() || p.isFrozen()) {}
        else if (this.getSusLevel() < 20) {
            int newSusLevel = p.getSusLevel() + (p.getSusLevel()/2) ;
            p.setSusLevel(newSusLevel);
        } else {
            int newSusLevel = p.getSusLevel() + (p.getSusLevel()/4) ;
            p.setSusLevel( newSusLevel);
        }
    }

    public boolean equals(Object o) {
        if (o instanceof RedAstronaut) {
            RedAstronaut p = (RedAstronaut) o;
            if(super.equals(p)) {
                return this.skill == p.getSkill();
            }
        }

        return false;
    }

    @Override
    public String toString(){
        String baseString = super.toString();
        String printString = baseString + "I am an " + skill + " player!";
        if (this.getSusLevel() > 15) {
            return printString.toUpperCase();
        } else {
            return printString;
        }
    }

    public String getSkill() {
        return skill;
    }
}
