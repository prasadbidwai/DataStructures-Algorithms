class LinkList{

	Link first;

	public LinkList(){
		first =null;
	}

	public boolean isEmpty(){

		return (first == null);
	}

	public void addFirstLink(int data){

		Link newLink = new Link(data);
		newLink.next =first;
		first = newLink;
	}

	public int deleteFirst(){

		Link temp = first;
		first = first.next;
		return temp.idata;
	}

	public void printLinkList(){

		Link current = first;
		while(current != null){
			current.displayLink();
			current = current.next;
		}
	}

	public Link findLink(int key){

		Link current = first;

		while(current.idata != key){
			if(current.next == null)
				return null;

			else
				current = current.next;
		}
		return current;
	}

	public Link deleteLink(int key){

		Link current = first;
		Link previous = first;

		while(current.idata != key){

			if (current.next == null)
			return null;

			else{

				previous = current;
				current = current.next;
			}
		}
		if(current == first)
			first = first.next;
		else
			previous.next = current.next;
		return current;
	}

}