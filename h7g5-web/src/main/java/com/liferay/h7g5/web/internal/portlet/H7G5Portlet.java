package com.liferay.h7g5.web.internal.portlet;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.h7g5.service.H7G5EntryService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.GenericPortlet;
import javax.portlet.Portlet;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"javax.portlet.display-name=H7G5"
	},
	service = Portlet.class
)
public class H7G5Portlet extends GenericPortlet {

	public H7G5Portlet() {
		System.out.println("Constructing H7G5Portlet");
	}

	@Override
	protected void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException {

		System.out.println("Invoking H7G5Portlet#doView");

		PrintWriter printWriter = renderResponse.getWriter();

		printWriter.println("Hello, H7G5!");

		System.out.println(
			"There are " + _h7g5EntryService.getH7G5EntriesCount() + " Entries.");

		
			try {
				_h7g5EntryService.addMyCustomH7G5EntryServiceWithPermissionCheck(
					StringUtil.randomString(), 
					StringUtil.randomString());
			} catch (Exception e) {

			}
		

		System.out.println(
			"After adding a new folder, there are now " +
			_h7g5EntryService.getH7G5EntriesCount() + " Entries.");
	}

	@Reference
	private H7G5EntryService _h7g5EntryService;

}