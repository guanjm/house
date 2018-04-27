package gjm.house.designPattern.behavioralPattern.interpreterPattern;

/**
 * 解释器模式
 * @author guanjm
 *
 */
public class Client {
	
	/**
	 * 客户端
	 * @author guanjm
	 * @param args
	 */
	public static void main(String[] args) {
		
		//创建环境
		Context context = new Context();
		//存入终结符所对应的具体值
		context.assign("100", 100);
		context.assign("200", 200);
		context.assign("a", 'a');
		context.assign("b", 'b');
		
		//创建终结符表达式
		Expression oneHundred = new TerminalExpression("100");
		Expression twoHundred = new TerminalExpression("200");
		Expression a = new TerminalExpression("a");
		Expression b = new TerminalExpression("b");
		
		//创建非终结符表达式
		Expression addExpression = new NonterminalExpression(oneHundred, twoHundred);
		Expression appendExpression = new NonterminalExpression(a, b);
		
		//解释
		System.out.println(addExpression.interpret(context));
		System.out.println(appendExpression.interpret(context));
	}

}
