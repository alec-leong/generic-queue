class Main {
  public static void main(String[] args) {
    try {
      QueueArrayList<Integer> primes = new QueueArrayList<>();

      System.out.println(primes.isEmpty()); // true

      primes.enqueue(2);
      primes.enqueue(3);
      primes.enqueue(5);
      primes.enqueue(7);
      primes.enqueue(11);

      System.out.println(primes.isFull()); // false
      System.out.println(primes.peek());   // 2
      System.out.println(primes.size());   // 5
      System.out.println(primes);
 
      int primeNum = primes.dequeue();

      System.out.println(primeNum);      // 2
      System.out.println(primes.size()); // 4
      System.out.println(primes);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

/* Output
true
false
2
5
[
 11,
 7,
 5,
 3,
 2
]
2
4
[
 11,
 7,
 5,
 3
]

*/
