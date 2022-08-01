package com.liferay.h7g7.web.internal.portlet;

import com.liferay.h7g7.model.H7G7Folder;
import com.liferay.h7g7.service.H7G7FolderLocalService;
import com.liferay.portal.kernel.util.StringUtil;

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
		"javax.portlet.display-name=H7G7"
	},
	service = Portlet.class
)
public class H7G7Portlet extends GenericPortlet {

	public H7G7Portlet() {
		System.out.println("Constructing H7G7Portlet");
	}

	@Override
	protected void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException {

		System.out.println("Invoking H7G7Portlet#doView");

		PrintWriter printWriter = renderResponse.getWriter();

		printWriter.println("Hello, H7G7!");

		System.out.println(
			"There are " + _h7g7FolderLocalService.getH7G7FoldersCount() +
				" folders.");

		H7G7Folder h7g7Folder = _h7G7FolderLocalService.createH7G7Folder(
			System.currentTimeMillis());

		h7g7Folder.setDescription(StringUtil.randomString());
		h7g7Folder.setName(StringUtil.randomString());

		_h7G7FolderLocalService.addH7G7Folder(h7g7Folder);

		System.out.println(
			"After adding a new folder, there are now " +
				_h7g7FolderLocalService.getH7G7FoldersCount() + " folders.");
	}

	@Reference
	private H7G7FolderLocalService _H7G7FolderLocalService;

}