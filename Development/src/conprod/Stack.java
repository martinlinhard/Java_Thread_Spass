/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package conprod;

/**
 *
 * @author martin
 */
public class Stack {
	private int[] values;
	private int tos = 0;
	
	public Stack(int i){
		values = new int[5];
	}
	
	public boolean isFull() {
		return tos == values.length;
	}
	
	public boolean isEmpty() {
		return tos == 0;
	}
	
	public void push(int val) {
		
		if (isFull())
			throw new RuntimeException("full");
		
		values[tos] = val;
		tos++;
	}
	
	public int pop() {
		if (isEmpty())
			throw new RuntimeException("empty");
		return values[--tos];
	}

	@Override
	public String toString() {
		if (isEmpty())
			return "[]";

		StringBuilder sb = new StringBuilder("[");
		for(int i =0; i < tos; i++){
			sb.append(values[i] + ",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		return sb.toString();
	}
	public static void main(String[] args) {
		Stack stack = new Stack(5);
		for(int i = 1; i <= 3; i++){
			stack.push(i);
		}
		System.out.println(stack);
	}
}
