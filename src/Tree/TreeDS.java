class TreeDS{

	Node root;

	public TreeDS(){
		root = null;
	}

	public void insert(int key){

		Node newNode = new Node(key);

		if(root == null){
			root = newNode;
		}

		else
		{
			Node current = root;

			while(true){

				Node parent = current;
				if(key < root.iData){

					current = current.leftChild;
					if(current == null)
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

		public Node find(int key){

			Node current = root;
			
			if (key == root.iData){
				return root;
			}
			else{
			
			while(key != current.iData){

				if(key < current.iData){
					current = current.leftChild;
				}

				else{
					current = current.rightChild;
				}
			}

			if(current == null){
				return null;
			}
			}
		return current;
		}
	}
}