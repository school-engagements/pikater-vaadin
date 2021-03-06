package org.pikater.web.vaadin.gui.server.components.dbviews;

import org.pikater.shared.database.views.base.ITableColumn;
import org.pikater.shared.database.views.base.values.AbstractDBViewValue;
import org.pikater.shared.database.views.tableview.AbstractTableRowDBView;
import org.pikater.shared.database.views.tableview.datasets.metadata.NumericalMetaDataTableDBView;
import org.pikater.web.vaadin.gui.server.components.dbviews.base.AbstractDBViewRoot;
import org.pikater.web.vaadin.gui.server.components.dbviews.base.tableview.DBTable;

import com.vaadin.ui.AbstractComponent;

/**
 * Configuration for {@link DBTable DB tables} working with numerical metadata.
 * 
 * @author SkyCrawl
 */
public class NumericalMetadataDBViewRoot extends AbstractDBViewRoot<NumericalMetaDataTableDBView> {
	public NumericalMetadataDBViewRoot(NumericalMetaDataTableDBView view) {
		super(view);
	}

	@Override
	public int getColumnSize(ITableColumn column) {
		NumericalMetaDataTableDBView.Column specificColumn = (NumericalMetaDataTableDBView.Column) column;
		switch (specificColumn) {
		case NAME:
			return 100;
		case IS_TARGET:
		case IS_REAL:
			return 25;

		case MINIMUM:
		case MAXIMUM:
		case AVERAGE:
		case MEDIAN:
		case SKEWNESS:
		case KURTOSIS:
		// case MODE:
		case CHI_SQUARE_NORM:
		case CHI_SQUARE_NORM_T:
			return 35;
		case G_TEST:
			return 45;
		case QUARTILE_1:
		case QUARTILE_2:
		case QUARTILE_3:
			return 25;
		case STD_DEVIATION:
		case VARIANCE:
			return 25;
		case RATIO_OF_MISSING_VALUES:
			return 25;
		case ENTROPY:
			return 30;
		case CLASS_ENTROPY:
			return 30;
		case COVARIANCE:
		case U_TEST:
		case KS_TEST:
			return 35;

		default:
			throw new IllegalStateException(String.format("No sizing information found for column '%s'", specificColumn.name()));
		}
	}

	@Override
	public ITableColumn getExpandColumn() {
		return NumericalMetaDataTableDBView.Column.CLASS_ENTROPY;
	}

	@Override
	public void onCellCreate(ITableColumn column, AbstractDBViewValue<?> value, AbstractComponent component) {
	}

	@Override
	public void approveAction(ITableColumn column, AbstractTableRowDBView row, Runnable action) {
	}
}