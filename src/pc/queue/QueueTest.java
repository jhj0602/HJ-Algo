package pc.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		// Queue<String> queue = new LinkedList<String>();
		// LinkedList<String> queue1 = new LinkedList<String>(); //queue .을 했을때 비교해보자
		// addFirst라는 메소드가 안나오는것을 볼수 있다. 그 이유는 뭘까 LinkedList라는 클래스는 큐 등 여러가지 기능 들을 가지고
		// 있다
		// 하지만 Queue라는 타입으로 명시를 해놓는다면 LinkedList의 수많은 기능이 있어도 Queue에 해당하는 기능들만 들어가게 된다.
		// 따라서 LinkedList에 모든 기능을 사용하고싶다면 Queue<E> queue = LinkedList 가 아닌 LinkedList<E>
		// queue = ListkedList로 만들어야한다.
		Queue<String> queue = new LinkedList<String>();
		System.out.println(queue.isEmpty() + "/" + queue.size());
		queue.offer("황선우");
		queue.offer("김연경");
		queue.offer("우상혁");
		queue.offer("여서정");
		System.out.println(queue.isEmpty() + "/" + queue.size());
		System.out.println(queue.peek());
		System.out.println(queue.isEmpty() + "/" + queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.isEmpty() + "/" + queue.size());
	}

}
