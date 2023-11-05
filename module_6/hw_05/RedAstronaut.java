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

    @Override
    public void emergencyMeeting(Player[] players) {
        if(!this.isFrozen()){
            Arrays.sort(players);
            int susInt = players.length - 1;
            if (this.equals(players[susInt])) {
                if (players[susInt - 1].getSusLevel() != players[susInt - 2].getSusLevel()) {
                    players[susInt - 1].setFrozen(true);
                } 
            } else {
                if (players[susInt].getSusLevel() != players[susInt - 1].getSusLevel()) {
                    players[susInt].setFrozen(true);
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
        if (this.getSusLevel() > 15) {
            return baseString.toUpperCase();
        } else {
            return baseString;
        }
    }

    public String getSkill() {
        return skill;
    }
}
