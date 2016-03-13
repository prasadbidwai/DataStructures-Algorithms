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
		
		public boolean deleteElement(int key)
		{
			Node current = root;
			Node parent = root;

			boolean isLeftChild = false;

			while(key != current.iData)
			{
				parent = current;

				if(key < current.iData)
				{
					isLeftChild = true;
					current = current.leftChild;
				}
				else
				{
					isLeftChild = false;
					current = current.rightChild;
				}

				if(current == null)
				{
					return null
				}
			}

			if(current.leftChild == null && current.rightChild == null)
			{
				if(isLeftChild)
				{
					parent.leftChild = null;
				}
				else
				{
					parent.rightChild = null;
				}
			}

			else if (current.leftChild == null)
			{
				if (current == root) 
				{
					root = current.rightChild;	
				}
				if(isLeftChild)
				{
					parent.leftChild = current.rightChild
				}
				else
				{
					parent.rightChild = current.rightChild
				}
			}

			else if(current.rightChild == null)
			{
				if (current == root) 
				{
					root = current.leftChild;
				}

				if (isLeftChild) {
					parent.leftChild = current.leftChild;
				}

				else
				{
					parent.rightChild = current.leftChild;
				}
			}
		return true;
		}

	}
