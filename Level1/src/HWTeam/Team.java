package HWTeam;

public class Team {

    private String nameTeam;
    private Participant[] participants;


    public Team(String name1, String name2, String name3, String name4, String nameTeam) {
        this.participants = new Participant[]{
                new BasicParticipant(name1, 150),
                new BasicParticipant(name2, 158),
                new BasicParticipant(name3, 180),
                new BasicParticipant(name4, 200)
        };
        this.nameTeam = nameTeam;

    }

    public Participant[] getParticipants() {
        return this.participants;
    }

    public void showResult() {
        System.out.println(nameTeam);
        for (int i = 0; i < participants.length; i++) {
            System.out.println(participants[i].toString());
        }
    }
}
