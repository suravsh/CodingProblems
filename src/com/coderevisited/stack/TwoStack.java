package com.coderevisited.stack;

import java.util.Iterator;

public class TwoStack<E> {

	private E[] array;

	@SuppressWarnings("unchecked")
	public TwoStack(int capacity) {
		array = (E[]) new Object[capacity];
		for (int i = 0; i < capacity; i++) {
			array[i] = null;
		}
	}

	public Stack<E> getUpStack() {
		return new UpStack();
	}

	public Stack<E> getDownStack() {
		return new DownStack();
	}

	private class DownStack implements Stack<E> {

		private int size = 0;
		private int N = array.length - 1;

		@Override
		public Iterator<E> iterator() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void push(E item) {
			if (array[N] != null) {
				throw new RuntimeException("Stack overflow");
			}
			array[N--] = item;
			size++;
		}

		@Override
		public E pop() {
			if (isEmpty())
				throw new RuntimeException("Stack underflow");
			E item = array[++N];
			array[N] = null;
			size--;
			return item;
		}

		@Override
		public E peek() {
			if (isEmpty())
				throw new RuntimeException("Stack underflow");
			return array[N + 1];
		}

		@Override
		public boolean isEmpty() {
			return N == array.length - 1;
		}

		@Override
		public int size() {
			return size;
		}

		@Override
		public boolean isFull() {
			return array[N] != null;
		}

	}

	private class UpStack implements Stack<E> {

		private int size = 0;
		private int N = 0;

		@Override
		public Iterator<E> iterator() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void push(E item) {
			if (array[N] != null) {
				throw new RuntimeException("Stack overflow");
			}
			array[N++] = item;
			size++;

		}

		@Override
		public E pop() {
			if (isEmpty())
				throw new RuntimeException("Stack underflow");
			E item = array[--N];
			array[N] = null;
			size--;
			return item;
		}

		@Override
		public E peek() {
			if (isEmpty())
				throw new RuntimeException("Stack underflow");
			return array[N - 1];
		}

		@Override
		public boolean isEmpty() {
			return N == 0;
		}

		@Override
		public int size() {
			return size;
		}

		@Override
		public boolean isFull() {
			return array[N] != null;
		}

	}

	public static void main(String[] args) {
		TwoStack<Integer> twoStacks = new TwoStack<>(5);
		Stack<Integer> stack1 = twoStacks.getDownStack();
		Stack<Integer> stack2 = twoStacks.getUpStack();

		stack1.push(2);
		stack2.push(4);
		stack1.push(6);
		stack2.push(6);
		stack1.push(9);

		System.out.println("Size of stack 1 " + stack1.size());
		System.out.println("Size of stack 2 " + stack2.size());
		
		
		System.out.println("Stack 1 is Full? " + stack1.isFull());
		System.out.println("Stack 2 is Full? " + stack2.isFull());
		
		
	}

}
