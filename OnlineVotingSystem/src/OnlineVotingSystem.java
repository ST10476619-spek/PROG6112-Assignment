
import java.util.Scanner;

class Person {
    private String name;
    private String nationalID; // unique ID for citizens

    public Person(String name, String nationalID) {
        this.name = name;
        this.nationalID = nationalID;
    }

    public String getName() {
        return name;
    }

    public String getNationalID() {
        return nationalID;
    }
}

// Candidate class
class Candidate extends Person {
    private String party;
    private int votes;

    public Candidate(String name, String nationalID, String party) {
        super(name, nationalID);
        this.party = party;
        this.votes = 0;
    }

    public void addVote() {
        votes++;
    }

    public int getVotes() {
        return votes;
    }

    public String getParty() {
        return party;
    }
}

//Voter class
class Voter extends Person {
    private boolean hasVoted;

    public Voter(String name, String nationalID) {
        super(name, nationalID);
        this.hasVoted = false;
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    public void castVote() {
        hasVoted = true;
    }
}
