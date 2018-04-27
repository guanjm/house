package gjm.house.designPattern.behavioralPattern.interpreterPattern;

/**
 * 非终结符表达式
 * 
 * 文法中的每一条规则都需要一个具体的非终结符表达式，非终结符表达式一般是文法中的运算符或者其他关键字
 * （比如公式R=R1+R2中，“+"就是非终结符，解析“+”的解释器就是一个非终结符表达式）
 * 
 * @author guanjm
 *
 */
//此处表示运算符+
public class NonterminalExpression implements Expression {
	
	private Expression left;
	
	private Expression right;
	
	public NonterminalExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public Object interpret(Context context) {
		
		Object leftExpression = left.interpret(context);
		Object rightExpression = right.interpret(context);
		
		if(leftExpression instanceof Integer && rightExpression instanceof Integer) {
			return (int)leftExpression + (int)rightExpression;
		} else if(leftExpression instanceof Character && rightExpression instanceof Character){
			return String.valueOf(leftExpression) + String.valueOf(rightExpression);
		} else {
			return null;
		}
	}

}
