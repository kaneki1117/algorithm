package book.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * add pollAll pollDog pollCat isEmpty isDogempty isCatEmpty
 * @author heyu1
 *这道题比较重要的就是他的设计思路
 */
public class CatDogQueue {
	Queue<PetEntity> dogQ = new LinkedList<>();
	Queue<PetEntity> catQ = new LinkedList<>();
	public static long count = 0;
	public static class PetEntity{
		private Pet pet;
		private long id;
		PetEntity(Pet pet,long id){
			this.pet = pet;
			this.id = id;
		}
	}
	public static class Pet {
		private String type;

		public Pet(String type) {
			this.type = type;
		}

		public String getPetType() {
			return this.type;
		}
	}

	public static class Dog extends Pet {
		public Dog() {
			super("dog");
		}
	}

	public static class Cat extends Pet {
		public Cat() {
			super("cat");
		}
	}
	
	public void add(Pet pet) {
		if(pet.getPetType().equals("dog")) {
			dogQ.offer(new PetEntity(pet,count++));
		}else if(pet.getPetType().equals("cat")) {
			catQ.offer(new PetEntity(pet,count++));
		}else {
			throw new RuntimeException("wrong type");
		}
	}
	//简单 略
	public void pollAll() {
		
	}
}
