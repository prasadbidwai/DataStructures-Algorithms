import java.util.*;

class TreeDS
{

Node root;

public TreeDS(){
	root = null;
}

public void insertElement(int key)
{

	Node newNode = new Node(key);
	
	if(root == null)
		root = newNode;

else
{
	Node current = root;
	Node parent;

	while(true)
	{
	parent = current;

	if(key < current.iData)
	{
		current = current.leftChild;
		if (current == null) 
		{
			parent.leftChild = newNode;
			return;	
		}
	}

	else{
		current = current.rightChild;
		if(current == null)
		{
			parent.rightChild = newNode;
			return;
		}
	}	
	}
}
}

public Node findElement(int key)
{
Node current = root;
	while(current.iData!= key)
	{
		if(key < current.iData)
		{
			current = current.leftChild;
		}
		else
		{
			current = current.rightChild;
		}
		if(current == null)
		{
			return null;
		}
	}
return current;
}

public void printLevelWise()
{
	Queue<Node> qn = new LinkedList<Node>();
	qn.add(root);

	while(!qn.isEmpty())
	{
		Node tempNode = qn.remove();
		System.out.print(tempNode.iData + " ");				
	
		if(tempNode.leftChild != null)
		{
			qn.add(tempNode.leftChild);
		}
		if(tempNode.rightChild != null)
		{
			qn.add(tempNode.rightChild);
		}
	}
}

public void InOrder(Node Localroot)
{
	if(Localroot != null)
	{
		InOrder(Localroot.leftChild);
		System.out.print(Localroot.iData+" ");
		InOrder(Localroot.rightChild);
	}
}

public void PreOrder(Node Localroot)
{
	if(Localroot != null)
	{
		System.out.print(Localroot.iData+" ");
		PreOrder(Localroot.leftChild);
		PreOrder(Localroot.rightChild);
	}
}

public void PostOrder(Node Localroot)
{
	if(Localroot != null)
	{
		PostOrder(Localroot.leftChild);
		PostOrder(Localroot.rightChild);
		System.out.print(Localroot.iData+" ");
	}
}
	
Node lca(Node node, int n1, int n2) {

	System.out.println("\n\ncalled the lca method");
	//System.out.println("with values:"+  node.iData+ " "+n1+ " "+n2);
    if (node == null) {
        return null;
    }

    // If both n1 and n2 are smaller than root, then LCA lies in left
    if (node.iData > n1 && node.iData > n2) 
    {
        System.out.println( node.leftChild.iData+ " "+n1+ " "+n2);
        return lca(node.leftChild, n1, n2);
        
    }

    // If both n1 and n2 are greater than root, then LCA lies in right
    else if (node.iData < n1 && node.iData < n2) {
        System.out.println( node.rightChild.iData+ " "+n1+ " "+n2);
        return lca(node.rightChild, n1, n2);

    }

    return node;
}


public boolean deleteElement(int key)
{
	Node current = root;
	Node parent = root;
	boolean isLeftChild = false;

	while(current.iData != key)
	{
		parent = current;
		if(key < current.iData)
		{
			current = current.leftChild;
			isLeftChild = true;					
		}
		else
		{
			current = current.rightChild;
			isLeftChild = false;
		}
		
		if(current == null)
			return false; 
	}

	if(current.leftChild == null && current.rightChild == null)
	{
		if(current == root)
			root = null;

		if(isLeftChild)
		{
			parent.leftChild = null;
		}
		else
		{
			parent.rightChild = null;
		}
	}

	if(current.leftChild == null)
	{
		if (current == root) 
		{
			root = current.rightChild;	
		}
		if(isLeftChild)
		{
			parent.leftChild = current.rightChild;
		}
		else
		{
			parent.rightChild = current.rightChild;
		}
	}

	if(current.rightChild == null)
	{
		if(current == root)
		{
			root = current.leftChild;
		}

		if(isLeftChild)
		{
			parent.leftChild = current.leftChild;
		}
		else
		{
			parent.rightChild =current.leftChild;
		}	
	}

	else
	{
		Node successor  = getSuccessor(current);

		if(current == root)
		{
			root = successor;
		}

		if(isLeftChild)
		{
			parent.leftChild = successor;
		}
		
		else
		{
			parent.rightChild = successor;
		}
	successor.leftChild = current.leftChild;	
	}
return true;	
}

private Node getSuccessor(Node delNode)
{
	Node successorParent = delNode;
	Node successor = delNode;
	Node current = delNode.rightChild; // go to right child
	while(current != null) // until no more
	{ // left children,
	successorParent = successor;
	successor = current;
	current = current.leftChild; // go to left child
	}
	// if successor not
	if(successor != delNode.rightChild) // right child,
	{ // make connections
	successorParent.leftChild = successor.rightChild;
	successor.rightChild = delNode.rightChild;
	}
	return successor;
}



}
