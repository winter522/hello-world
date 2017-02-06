package org.winter.test;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
	private static final int max=100;
	private Queue<Food> queue=new LinkedList<>();
	
	public Queue<Food> getQueue() {
		return queue;
	}

	public void setQueue(Queue<Food> queue) {
		this.queue = queue;
	}
	public void production(int num){
		synchronized (queue) {
			while(queue.size()+num>=max){
				System.out.println("��Ҫ����"+num+"��"+"�����������������������ˣ��ִ洢���ǣ�"+queue.size());
				try {
					queue.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
		for(int i=0;i<num;i++){
			/*try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			queue.add(new Food("ʳƷ"+i));
		}
		System.out.println("������ϣ�������Ϊ"+num+",���ڵĿ������"+queue.size());
		queue.notifyAll();
		}
	}
	public void consume(int num){
		if(num<=0){
			throw new RuntimeException("�����в���");
		}
		synchronized (queue) {
			while(queue.size()<num){
				System.out.println("��Ҫ����"+num+"��,"+"���д洢�����������Ժ�����ȡ���ִ洢���ǣ�"+queue.size());
				try {
					queue.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
		for(int i=0;i<num;i++){
			/*try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			queue.remove();
		}
		
		System.out.println("������ϣ�������Ϊ"+num+",���ڵĿ������"+queue.size());
		queue.notifyAll();
		}
	}
}
