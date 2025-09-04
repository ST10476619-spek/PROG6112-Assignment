
import java.util.Scanner;

public class VotingSystem {
    private static Candidate[] candidates = new Candidate[10];
    private static Voter[] voters = new Voter[100];
    private static int candidateCount = 0;
    private static int voterCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Online Government Voting System ===");
            System.out.println("1. Register Candidate (Government Only)");
            System.out.println("2. Register Voter (Citizen)");
            System.out.println("3. Cast Vote");
            System.out.println("4. Show Election Results");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> registerCandidate();
                case 2 -> registerVoter();
                case 3 -> castVote();
                case 4 -> showResults();
                case 0 -> System.out.println("System closed.");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private static void registerCandidate() {
        if (candidateCount >= candidates.length) {
            System.out.println("Maximum candidates reached.");
            return;
        }

        System.out.print("Enter candidate name: ");
        String name = scanner.nextLine();

        System.out.print("Enter candidate national ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter candidate party: ");
        String party = scanner.nextLine();

        candidates[candidateCount++] = new Candidate(name, id, party);
        System.out.println("Candidate registered successfully!");
    }

    private static void registerVoter() {
        if (voterCount >= voters.length) {
            System.out.println("Maximum voters registered.");
            return;
        }

        System.out.print("Enter voter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter voter national ID: ");
        String id = scanner.nextLine();

        // Prevent duplicate registration
        for (int i = 0; i < voterCount; i++) {
            if (voters[i].getNationalID().equals(id)) {
                System.out.println("This voter is already registered.");
                return;
            }
        }

        voters[voterCount++] = new Voter(name, id);
        System.out.println("Voter registered successfully!");
    }

    private static void castVote() {
        System.out.print("Enter your national ID: ");
        String id = scanner.nextLine();

        Voter voter = null;
        for (int i = 0; i < voterCount; i++) {
            if (voters[i].getNationalID().equals(id)) {
                voter = voters[i];
                break;
            }
        }

        if (voter == null) {
            System.out.println("Voter not registered.");
            return;
        }

        if (voter.hasVoted()) {
            System.out.println("You have already voted. Multiple votes not allowed.");
            return;
        }

        System.out.println("\n--- Candidates ---");
        for (int i = 0; i < candidateCount; i++) {
            System.out.println((i + 1) + ". " + candidates[i].getName() + " (" + candidates[i].getParty() + ")");
        }

        System.out.print("Enter the number of the candidate you want to vote for: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > candidateCount) {
            System.out.println("Invalid candidate choice.");
            return;
        }

        candidates[choice - 1].addVote();
        voter.castVote();
        System.out.println("Thank you for participating in the election!");
    }

    private static void showResults() {
        System.out.println("\n=== Election Results ===");
        if (candidateCount == 0) {
            System.out.println("No candidates registered yet.");
            return;
        }

        for (int i = 0; i < candidateCount; i++) {
            System.out.println(candidates[i].getName() + " (" + candidates[i].getParty() + ") - Votes: " + candidates[i].getVotes());
        }
    }
}
