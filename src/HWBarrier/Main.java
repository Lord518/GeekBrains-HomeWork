package HWBarrier;

import HWBarrier.Course;
import HWTeam.BasicParticipant;
import HWTeam.Participant;
import HWTeam.Team;

import javax.script.ScriptException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws ScriptException {

        Team t =new Team("Oleg","Stas","Petr","Roma","SuperTeam");
        Course c = new Course();
        c.dolt(t);



    }

}
