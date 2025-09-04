

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
/**
 *
 * @author lab_services_student
 */
public class VotingSystem {
    private Candidate candidate1;
    private Candidate candidate2;
    private Voter voter1;
    private Voter voter2;

    @BeforeEach
    void setUp() {
        candidate1 = new Candidate("Alice", "1234567890", "PartyA");
        candidate2 = new Candidate("Bob", "0987654321", "PartyB");

        voter1 = new Voter("Charlie", "1111111111");
        voter2 = new Voter("Diana", "2222222222");
    }

    // Test Candidate getters
    @Test
    void testCandidateGetters() {
        assertEquals("Alice", candidate1.getName());
        assertEquals("1234567890", candidate1.getNationalID());
        assertEquals("PartyA", candidate1.getParty());
        assertEquals(0, candidate1.getVotes());
    }

    // Test adding votes
    @Test
    void testCandidateAddVote() {
        candidate1.addVote();
        candidate1.addVote();
        assertEquals(2, candidate1.getVotes());
    }

    // Test Voter getters
    @Test
    void testVoterGetters() {
        assertEquals("Charlie", voter1.getName());
        assertEquals("1111111111", voter1.getNationalID());
        assertFalse(voter1.hasVoted());
    }

    // Test casting a vote
    @Test
    void testVoterCastVote() {
        voter1.castVote();
        assertTrue(voter1.hasVoted());
    }

    @Test
    void testVoterVotingTwice() {
        voter1.castVote();
        assertTrue(voter1.hasVoted());

        voter1.castVote();
        assertTrue(voter1.hasVoted(), "Voter should still be marked as having voted");
    }
}
    
    
    
   
        
        
    
    

