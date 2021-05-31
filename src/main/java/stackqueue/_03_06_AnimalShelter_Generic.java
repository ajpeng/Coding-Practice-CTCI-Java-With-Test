package stackqueue;

import java.util.LinkedList;

public class _03_06_AnimalShelter_Generic {
    abstract class Animal  {
        private int order;
        protected String name;
        public Animal(String n) { name =  n; }
        public void setOrder(int ord) { order = ord;}
        public int getOrder() { return order; }
    }

    class AnimalQueue {
        LinkedList<Dog> dogs = new LinkedList<>();
        LinkedList<Cat> cats = new LinkedList<>();
        private int order = 0;

        public void enqueue(Animal a) {
            a.setOrder(order);
            order++;
            if (a instanceof Dog) dogs.add( (Dog) a );
            else if (a instanceof Cat) cats.add( (Cat) a);
        }

        public Animal dequeueAny() {
            if (dogs.size() == 0 ) {
                return dequeueCats();
            } else if (cats.size() == 0) {
                return dequeueDogs();
            } else if (dogs.peek().getOrder() > cats.peek().getOrder()){
                return dequeueCats();
            } else {
                return dequeueDogs();
            }
        }

        public Cat dequeueCats() {
            return cats.poll();
        }

        public Dog dequeueDogs () {
            return dogs.poll();
        }
    }

    public class Dog extends Animal {
        public Dog(String n ) { super(n);}
    }

    public class Cat extends Animal {
        public Cat(String n ) { super(n);}
    }




}
