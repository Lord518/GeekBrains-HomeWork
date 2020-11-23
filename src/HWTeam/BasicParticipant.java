package HWTeam;

import HWBarrier.Barrier;

public  class BasicParticipant implements Participant {
    private String name;
    private int stamina;
    private boolean distance ;
public BasicParticipant(String name, int stamina)
{
    this.name=name;
    this.stamina=stamina;

}
 BasicParticipant(){}


    @Override
    public boolean doActivity(Barrier b) {
        return distance = b.pass(stamina);



    }

    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }
}
