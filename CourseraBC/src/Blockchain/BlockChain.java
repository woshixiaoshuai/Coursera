package Blockchain;

import java.awt.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

// Block Chain should maintain only limited block nodes to satisfy the functions
// You should not have all the blocks added to the block chain in memory 
// as it would cause a memory overflow.

public class BlockChain {
    public static final int CUT_OFF_AGE = 10;
    private TreeMap<String ,Block> blocks;
    private TreeNode<Block> blockChain;
   
    /**
     * create an empty block chain with just a genesis block. Assume {@code genesisBlock} is a valid
     * block
     */
    public BlockChain(Block genesisBlock) {
        // IMPLEMENT THIS
    	blocks = new TreeMap<String ,Block>();
    	
    	blocks.put(genesisBlock.getHash().toString(),genesisBlock);
    	blockChain = new TreeNode<Block>(genesisBlock );
    	
    	
    }

    /** Get the maximum height block */
    public Block getMaxHeightBlock() {
        // IMPLEMENT THIS
//    	Block block = new Block(prevHash, address);
    	blockChain.getHeight(blockChain);
    	
    	return null;
    }

    /** Get the UTXOPool for mining a new block on top of max height block */
    public UTXOPool getMaxHeightUTXOPool() {
        // IMPLEMENT THIS
    	return null;
    }

    /** Get the transaction pool to mine a new block */
    public TransactionPool getTransactionPool() {
        // IMPLEMENT THIS
    	return null;
    }

    /**
     * Add {@code block} to the block chain if it is valid. For validity, all transactions should be
     * valid and block should be at {@code height > (maxHeight - CUT_OFF_AGE)}.
     * 
     * <p>
     * For example, you can try creating a new block over the genesis block (block height 2) if the
     * block chain height is {@code <=
     * CUT_OFF_AGE + 1}. As soon as {@code height > CUT_OFF_AGE + 1}, you cannot create a new block
     * at height 2.
     * 
     * @return true if block is successfully added
     */
    public boolean addBlock(Block block) {
        // IMPLEMENT THIS
    	boolean ok = false;
    	if (block.getHash() == null) {
			return false;
		}
    	for (Transaction tx : block.getTransactions()) {
			
		}
    	blocks.put(block.getHash().toString(), block);
    	ok = true;
    	return ok;
    }

    /** Add a transaction to the transaction pool */
    public void addTransaction(Transaction tx) {
        // IMPLEMENT THIS
    }
}
final class TreeNode<T> {
	private ArrayList<TreeNode<T>> children = new ArrayList<TreeNode<T>>();
	private T data = null;
	public TreeNode(T data) {
		this.data = data;
	}
	public ArrayList<TreeNode<T>> getChildren(){
		return children;
	}
	public void setChild(TreeNode<T> children) {
		this.children.add(children);
	}
	public Integer getHeight(TreeNode<T> root) {
		if (root == null) {
			return 0;
		}
		Integer hInteger = 0;
		for(TreeNode<T> n : root.getChildren()){
            hInteger = Math.max(hInteger, getHeight(n));
        }
        return hInteger+1;
	}
	
	
	
	
	
	
	
}