package com.aidasoftware.qa.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Execution Of Project Tests Started!");

		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onTestStart(ITestResult result) {

		String testName = result.getName();
		System.out.println(testName + " Execution Started!");

		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String testName = result.getName();
		System.out.println(testName + " Got Succussfully Executed!");

		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String testName = result.getName();
		System.out.println(testName + "Got Failed!");
		System.out.println(result.getThrowable());

		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		String testName = result.getName();
		System.out.println(testName + " Test Got Skipped!");
		System.out.println(result.getThrowable());
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	/* @Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	} */

	/* @Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	} */

	@Override
	public void onFinish(ITestContext context) {

		System.out.println("Finished Executing Project Tests");

		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
	}

}
