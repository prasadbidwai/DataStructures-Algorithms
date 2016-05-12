class TreeDS{

	Node root;

	public TreeDS(){
		root = null;
	}

public void insertElement(int key)
	{

		Node newNode = new Node(key);

		if(root == null){
			root = newNode;
		}

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
					if(current == null)
					{
						parent.leftChild = newNode;
						return;
					}
				}
				else
				{
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
				System.out.println(tempNode.iData + " ");				
			
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
			System.out.println(Localroot.iData);
			InOrder(Localroot.rightChild);
		}
	}

	public void PreOrder(Node Localroot)
	{
		if(Localroot != null)
		{
			System.out.println(Localroot.iData);
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
			System.out.println(Localroot.iData);
		}
	}

	public boolean deleteElement(int key)
	{
		TheNode current = root;
		TheNode parent = root;

		boolean isLeftChild = true;

		while(current.iData != key)	
		{
			if(key < current.iData)
			{
				current = current.leftChild;
				isLeftChild =true;
			}

			else
			{
				current = current.rightChild;
				isLeftChild =false;
			}
			
			if (current == null) 
			{
				return false;	
			}
		}

		if(current.leftChild == null && current.rightChild == null)
		{
			if(current == root)
			{
				root = null;
			}

			else if(isLeftChild)
			{
				parent.leftChild = null;
			}

			else
			{
				parent.rightChild =null;
			}

		}

		else if(current.leftChild == null)
		{
			if (current == root)
			{
				root =current.rightChild;
			}
			else if(isLeftChild)
			{
				parent.leftChild = current.rightChild;
			}
			else
			{
				parent.rightChild =current.rightChild;
			}
		}

		else if(current.rightChild == null)
		{
			if(current == root)
			{
				root = current.leftChild;
			}

			else if (isLeftChild)
			{
				parent.leftChild = current.leftChild;
			}
			else
			{
				parent.rightChild = current.rightChild;
			}
		}

		else
		{

			TheNode succesor = getSuccsor(current);

			if (current == root) 
			{
					root = succesor;
			}
			else if (isLeftChild)
			{
				parent.leftChild = succesor;
			}
			else
			{
				parent.rightChild = succesor;
			}
		succesor.leftChild = current.leftChild
		}
	
	return true;
	}

	}
