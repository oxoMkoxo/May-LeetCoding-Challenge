/*
 * 	901. Online Stock Span
 * 
 * Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's 
 * price for the current day.
 * 
 * The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and 
 * going backwards) for which the price of the stock was less than or equal to today's price.
 * 
 * For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans 
 * would be [1, 1, 1, 2, 1, 4, 6].
 * 
 * 	Example 1:
 * 		Input: ["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
 * 		Output: [null,1,1,1,2,1,4,6]
 * 	Explanation:
 * 		First, S = StockSpanner() is initialized.  Then:
 * 		S.next(100) is called and returns 1,
 * 		S.next(80) is called and returns 1,
 * 		S.next(60) is called and returns 1,
 * 		S.next(70) is called and returns 2,
 * 		S.next(60) is called and returns 1,
 * 		S.next(75) is called and returns 4,
 * 		S.next(85) is called and returns 6.
 * 
 * 	Note that (for example) S.next(75) returned 4, because the last 4 prices
 * 	(including today's price of 75) were less than or equal to today's price.
 * 
 *	Note:
 *		Calls to StockSpanner.next(int price) will have 1 <= price <= 10^5.
 *		There will be at most 10000 calls to StockSpanner.next per test case.
 *		There will be at most 150000 calls to StockSpanner.next across all test cases.
 *		The total time limit for this problem has been reduced by 75% for C++, and 50% for all other languages.
 * 
 */

package Week3;

import java.util.*;

public class OnlineStockSpan {

	class Node {
		int price;
		int spanTillDate; // answer till that date

		Node(int price) {
			this.price = price;
			this.spanTillDate = 1;
		}
	}

	Stack<Node> stack;

	public OnlineStockSpan() {
		stack = new Stack<>();
	}

	public int next(int price) {
		Node node = new Node(price);
		while (!stack.isEmpty() && stack.peek().price <= price) {
			node.spanTillDate += stack.pop().spanTillDate;
		}
		stack.push(node);
		return node.spanTillDate;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String opp = scn.next();
		StringTokenizer st = new StringTokenizer(opp, "[,\\[\\]\"]");
		String val = scn.next();
		StringTokenizer st2 = new StringTokenizer(val, "[\\[\\],]");
//		while(st2.hasMoreTokens()) {
//			System.out.println(st2.nextToken());
//		}
		OnlineStockSpan obj = null;
		while (st.hasMoreTokens()) {
			switch (st.nextToken()) {
			case "StockSpanner":
				obj = new OnlineStockSpan();
				System.out.print("[null,");
				break;
			case "next":
				System.out.print(obj.next(Integer.parseInt(st2.nextToken())));
				if (st.hasMoreTokens()) {
					System.out.print(",");
				} else {
					System.out.print("]");
				}
				break;
			default:
				break;
			}

		}

		scn.close();
	}

}
