public class Hero {
    private String name;
    public int hitPoints;
    public Hero(String name){
        this.name = name;
        hitPoints = 100;
    }
    public String getName(){
        return name;
    }
    public int getHitPoints(){
        return hitPoints;
    }
    public String toString(){
        return "Hero{name=\'" + name + "\', hitPoints=" + hitPoints + "}";
    }
    public void attack(Hero opponent){
        double num = Math.random();
        if(num < 0.5){
            opponent.hitPoints -= 10;
        }else{
            hitPoints -= 10;
        }
    }
    public void senzuBean(){
        hitPoints = 100;
    }
    private void fightUntilTheDeathHelper(Hero opponent){
        while(opponent.hitPoints > 0 && hitPoints > 0){
            attack(opponent);
        }
    }
    public String fightUntilTheDeath(Hero opponent){
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return name + ": " + hitPoints + "\t" + opponent.name + ": " + opponent.hitPoints;
    }
    public int[] nFightsToTheDeathHelper(Hero opponent, int n){
        int hwins = 0;
        int owins = 0;
        int log[] = new int[2];
        for(int i=0;i<n;i++){
            senzuBean();
            opponent.senzuBean();
            fightUntilTheDeathHelper(opponent);
            if(hitPoints == 0){
                owins++;
            }else hwins++;
        }
        log[0] = hwins;
        log[1] = owins;
        return log;
    }
    public String nFightsToTheDeath(Hero opponent, int n){
        String ans = "";
        int log[] = new int[2];
        log = nFightsToTheDeathHelper(opponent, n);
        ans = name + ": " + log[0] + " wins\n" + opponent.name + ": " + log[1] + " wins\n";
        if(log[0] == log[1]){
            ans += "OMG! It was actually a draw!";
        }else if(log[0] > log[1]){
            ans += name + " wins!";
        }else{
            ans += opponent.name + " wins!";
        }
        return ans;
    }
    public void dramaticFightToTheDeath(Hero opponent){
        try{
            senzuBean();
            opponent.senzuBean();
            while(opponent.hitPoints > 0 && hitPoints > 0){
                attack(opponent);
                Thread.sleep(1000);
                System.out.println(name + ": " + hitPoints + "\t" + opponent.name + ": " + opponent.hitPoints);
            }
            if(hitPoints > 0){
                System.out.println(name + " wins!");
            }else{
                System.out.println(opponent.name + " wins!");
            }
        }
        catch(InterruptedException e){
            System.out.println("error");
        }
    }
}
