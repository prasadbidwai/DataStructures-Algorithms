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

	}
