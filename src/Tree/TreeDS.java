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

	}
