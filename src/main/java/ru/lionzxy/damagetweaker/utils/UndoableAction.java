package ru.lionzxy.damagetweaker.utils;

/*
 * MTUtils is the software thich is made by LionZXY under GNU Affero General Public License
 * Please see LICENSE file or https://www.gnu.org/licenses/agpl-3.0.en.html
 *
 * This build is modified by monatann under same LICENSE, AGPL.
 * You do not report bugs to original author.
 * You should report to me because your bug is caused by my code.
 * */

import minetweaker.IUndoableAction;

public class UndoableAction implements IUndoableAction {
	private final String mDescription;
	private final Runnable mApplyAction;
	private final String mUndoDescription;
	private final Runnable mUndoAction;

	public UndoableAction(String pDescription, Runnable pApplyAction, String pUndoDescription, Runnable pUndoAction) {
		mDescription = pDescription;
		mApplyAction = pApplyAction;
		mUndoDescription = pUndoDescription;
		mUndoAction = pUndoAction;
	}

	@Override
	public void apply() {
		mApplyAction.run();
	}

	@Override
	public boolean canUndo() {
		return mUndoAction != null;
	}

	@Override
	public String describe() {
		return mDescription;
	}

	@Override
	public String describeUndo() {
		return mUndoDescription;
	}

	@Override
	public Object getOverrideKey() {
		return null;
	}

	@Override
	public void undo() {
		mUndoAction.run();
	}

}
