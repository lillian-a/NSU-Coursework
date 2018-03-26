public class IterableLinkedList extends LinkedList {
	class GofLinkedListIterator extends GofIterator {
		
		private Link cursor;
		
		GofLinkedListIterator() {
			cursor = head;
		}

		@Override
		void first() {
			cursor = head;
		}

		@Override
		void next() {
			if(!isDone())
				cursor = cursor.next;
		}

		@Override
		boolean isDone() {
			return cursor == null;
		}

		@Override
		String currentItem() {
			if (cursor == null) {
				return "";
			} else {
				String returnString = cursor.name;
				return returnString;
			}
		}
	}
	
	class JavaLinkedListIterator extends JavaIterator {
		
		// private Link cursor = head;
		private Link cursor;
		
		JavaLinkedListIterator() {
			cursor = head;
		}
		
		@Override
		boolean hasNext() {
			return (cursor != null);
		}

		@Override
		String next() {
			if (cursor == null) {
				return "";
			} else {
				String returnString = cursor.name;
				cursor = cursor.next;
				return returnString;
			}
		}
	}
	
	public GofIterator createGofIterator() {
		return new GofLinkedListIterator();
	}
	
	public JavaIterator createJavaIterator() {
		return new JavaLinkedListIterator();
	}
}