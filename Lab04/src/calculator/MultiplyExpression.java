package calculator;

class MultiplyExpression extends BinaryExpression {

   public MultiplyExpression(final Expression lft, final Expression rht) {
      super(lft,rht, "*");
   }

   @Override
   protected double _applyOperator(Double lft, Double rht) {
      return lft * rht;
   }
}

