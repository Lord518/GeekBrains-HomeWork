package HWBarrier;

import HWTeam.BasicParticipant;
import HWTeam.Participant;
import HWTeam.Team;

import java.util.Random;

public class Course extends BasicBarrier {
    Random random = new Random();
    Barrier[] barriers;

    public Course() {
        barriers = new BasicBarrier[]{
                new BasicBarrier(random.nextInt(200)),
                new BasicBarrier(random.nextInt(160)),
                new BasicBarrier(random.nextInt(150)),
                new BasicBarrier(random.nextInt(165))
        };

    }

    public void dolt(Team t) {
        Participant[] p = t.getParticipants();
        for (int i = 0; i < p.length; i++) {
            System.out.println(barriers[i].toString());
            for (int j = 0; j < barriers.length; j++) {
                p[j].doActivity(barriers[i]);
            }
            t.showResult();

        }

    }
}


