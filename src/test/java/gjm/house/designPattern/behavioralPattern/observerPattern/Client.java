package gjm.house.designPattern.behavioralPattern.observerPattern;

/**
 * 观察者模式/发布-订阅(Publish/Subscribe)模式/模型-视图(Model/View)模式/源-监听器(Source/Listener)模式/从属者(Dependents)模式
 * 
 * 推模型：目标对象向观察者推送目标的详细信息，不管观察者是否需要，推送的信息通常是主题对象的全部或部分数据。
 * 拉模型：主题对象在通知观察者的时候，只传递少量信息。如果观察者需要更具体的信息，由观察者主动到主题对象中获取，相当于是观察者从主题对象中拉数据。
 * 		一般这种模型的实现中，会把主题对象自身通过update()方法传递给观察者，这样在观察者需要获取数据的时候，就可以通过这个引用来获取了。
 * 
 * @author guanjm
 *
 */
public class Client {
	
	public static void main(String[] args) {
		
		/**
		 * 推模型
		 */
		//创建两个观察者
		PushObserver observer1 = new ConcretePushObserver();
		PushObserver observer2 = new ConcretePushObserver();
		//创建被观察者
		ConcretePushSubject concretePushSubject = new ConcretePushSubject();
		//注册观察者
		concretePushSubject.attach(observer1);
		concretePushSubject.attach(observer2);
		//被观察者发生变更
		concretePushSubject.change("1");
		System.out.println("-------------split line--------------");
		concretePushSubject.change("2");
		
		System.out.println("------------------------------------------------");
		
		/**
		 * 拉模型
		 */
		//创建两个观察者
		PullObserver Observer1 = new ConcretePullObserver();
		PullObserver Observer2 = new ConcretePullObserver();
		//创建被观察者
		ConcretePullSubject concretePullSubject = new ConcretePullSubject();
		//注册观察者
		concretePullSubject.attach(Observer1);
		concretePullSubject.attach(Observer2);
		//被观察者发生变更
		concretePullSubject.change("1", "one");
		System.out.println("-------------split line--------------");
		concretePullSubject.change("2", "two");
	}

}
