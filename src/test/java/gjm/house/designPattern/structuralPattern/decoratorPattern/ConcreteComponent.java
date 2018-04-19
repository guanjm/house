package gjm.house.designPattern.structuralPattern.decoratorPattern;

/**
 * 具体构件
 * 
 * 定义一个将要接收附加责任的类
 * 
 * @author guanjm
 *
 */
public class ConcreteComponent implements Component {

	@Override
	public void function() {
		System.out.println(" this is ConcreteComponent! ");
	}

}
