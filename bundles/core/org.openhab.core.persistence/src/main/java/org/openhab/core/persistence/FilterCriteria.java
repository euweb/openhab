/**
 * openHAB, the open Home Automation Bus.
 * Copyright (C) 2010-2012, openHAB.org <admin@openhab.org>
 *
 * See the contributors.txt file in the distribution for a
 * full listing of individual contributors.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses>.
 *
 * Additional permission under GNU GPL version 3 section 7
 *
 * If you modify this Program, or any covered work, by linking or
 * combining it with Eclipse (or a modified version of that library),
 * containing parts covered by the terms of the Eclipse Public License
 * (EPL), the licensors of this Program grant you additional permission
 * to convey the resulting work.
 */
package org.openhab.core.persistence;

import java.util.Date;

import org.openhab.core.types.State;

/**
 * This class is used to define a filter for queries to a {@link PersistenceService}.
 * 
 * <p>It is designed as a Java bean, for which the different properties are constraints
 * on the query result. These properties include the item name, begin and end date and
 * the item state. A compare operator can be defined to compare not only state equality,
 * but also its decimal value (<,>).<p>
 * <p>Additionally, the filter criteria supports paging of the result, so the caller can ask
 * to only return chunks of the result of a certain size (=pageSize) from a starting index
 * (pageNumber*pageSize).</p>
 * <p>All setter methods return the filter criteria instance, so that the methods can be
 * easily chained in order to define a filter.
 * 
 * @author Kai Kreuzer
 * @since 1.0.0
 */
public class FilterCriteria {

	/** Enumeration with all possible compare options */
	public enum Operator {
		EQ("="),
		NEQ("!="),
		GT(">"), 
		LT("<"), 
		GTE(">="), 
		LTE("<=");
		
		private final String symbol;
		
		Operator(String symbol) {
			this.symbol = symbol;
		}
		
		String getSymbol() {
			return symbol;
		}
	}

	/** filter result to only contain entries for the given item */
	private String itemName;

	/** filter result to only contain entries that are newer than the given date */
	private Date beginDate;
	
	/** filter result to only contain entries that are older than the given date */
	private Date endDate;

	/** return the result list from starting index pageNumber*pageSize only */
	private int pageNumber = 0;
	
	/** return at most this many results */
	private int pageSize = Integer.MAX_VALUE;

	/** use this operator to compare the item state */
	private Operator operator = Operator.EQ;

	/** filter result to only contain entries that evaluate to true with the given operator and state */
	private State state;

	public String getItemName() {
		return itemName;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public Operator getOperator() {
		return operator;
	}

	public State getState() {
		return state;
	}

	public FilterCriteria setItemName(String itemName) {
		this.itemName = itemName;
		return this;
	}

	public FilterCriteria setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
		return this;
	}

	public FilterCriteria setEndDate(Date endDate) {
		this.endDate = endDate;
		return this;
	}

	public FilterCriteria setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
		return this;
	}

	public FilterCriteria setPageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	public FilterCriteria setOperator(Operator operator) {
		this.operator = operator;
		return this;
	}

	public FilterCriteria setState(State state) {
		this.state = state;
		return this;
	}

}