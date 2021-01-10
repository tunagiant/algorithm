package other;

import java.util.PriorityQueue;

public class priorityqueue {
	public static void main(String[] args) {
		PriorityQueue<Vehicle> pq = new PriorityQueue<>();
		pq.add(new Vehicle("대중교통", 70));
		pq.add(new Vehicle("자가용", 45));
		pq.add(new Vehicle("오토바이", 45));
		pq.add(new Vehicle("도보", 400));
		pq.add(new Vehicle("자전거", 125));

		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

	// pq에 클래스변수를 넣으려면 해당클래스는 comparable구현, compareTo메서드 오버라이딩
	static class Vehicle implements Comparable<Vehicle> {
		private String name;
		private int time;

		Vehicle(String name, int time) {
			this.name = name;
			this.time = time;
		}

		public String getName() {
			return name;
		}

		public int getTime() {
			return time;
		}

		@Override
		public String toString() {
			return "Vehicle{" + "name='" + name + '\'' + ", time=" + time + '}';
		}

		
		// name, time중 어떤것을 우선순위기준으로?
		@Override
		public int compareTo(Vehicle that) {
			if (this.time == that.time)
				return this.name.compareTo(that.name);
			return this.time - that.time;
		}
	}
}
/*
 * 결과
 * Vehicle{name='오토바이',time=45}
 * Vehicle{name='자가용',time=45}
 * Vehicle{name='대중교통', time=70}
 * Vehicle{name='자전거',time=125}
 * Vehicle{name='도보',time=400}
 */