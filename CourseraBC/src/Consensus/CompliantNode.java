package Consensus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;

/* CompliantNode refers to a node that follows the rules (not malicious)*/
public class CompliantNode implements Node {

    private ArrayList<Transaction> transactions;
    private Set<Candidate> nodeCandidates ;
    private ArrayList<CompliantNode> compliantNodes ;
    private Node[] nodes ;
    private boolean[] myFollowees;
    private Set<Transaction > transactionsToFollowers;
    private Set<Transaction> consensus;
    private Set<Transaction> pendingTransactions;
    private HashSet<Candidate > proposals;
    private int numberOfRounds;
    private int round;
	public CompliantNode(double p_graph, double p_malicious, double p_txDistribution, int numRounds) {
        // IMPLEMENT THIS
		numberOfRounds = numRounds;
		round = 0;
		transactionsToFollowers = new HashSet<Transaction>();
    }
    // 1. 
    public void setFollowees(boolean[] followees) {
        // IMPLEMENT THIS
    	myFollowees = followees;
    	nodes = new Node[followees.length];
    	
    	
    }

    public void setPendingTransaction(Set<Transaction> pendingTransactions) {
        // IMPLEMENT THIS
//    	transactions = new ArrayList<Transaction>(pendingTransactions);
    	
    	this.pendingTransactions = pendingTransactions;
    	
    	
    }

    public Set<Transaction> sendToFollowers() {
        // IMPLEMENT THIS
    	if (round == 0) {
    		return this.pendingTransactions;
		} else {
			// 1. calculate consensus
			
			// 2. return consensus
			return consensus;
		}
    	
    }

    public void receiveFromFollowees(Set<Candidate> candidates) {
        // IMPLEMENT THIS
    	
    	for (Candidate candidate : candidates) {
			if (candidate.tx == null) continue;
    		if (myFollowees[candidate.sender] == true) {

    			this.transactionsToFollowers.add(candidate.tx);
    			
			}

		}
    	round++;
    }
}
