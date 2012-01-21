OpenLayers.IMAGE_RELOAD_ATTEMPTS = 5;
// get rid of pink error tiles
OpenLayers.Util.onImageLoadErrorColor = "transparent";
// make OL compute scale according to WMS spec
OpenLayers.DOTS_PER_INCH = 25.4 / 0.28;

// Global
var map, gmap, features, selectedFeature;

// options set for the map.
// controls - are the list of controls (empty for now so we can add as needed)
// maxResolution - the max pixel to meter? resolution?
// projection - the projection model used. 4326 is the WMS standard.
var options = {
	controls : [],
	panDuration : 100,
	projection : new OpenLayers.Projection("EPSG:4326")
};

// called on page load
function init() {
	// The Map!
	map = new OpenLayers.Map('map', options);
	map.addControl(new OpenLayers.Control.LayerSwitcher());
	map.addControl(new OpenLayers.Control.PanZoomBar());

	// Google Maps layer
	gmap = new OpenLayers.Layer.Google("Google Streets", {
		numZoomLevels : 20
	});

	// Features Layer
	features = new OpenLayers.Layer.Vector("Features");

	// Test KML Layer
	var kml = new OpenLayers.Layer.Vector("KML", {
		strategies : [new OpenLayers.Strategy.Fixed()],
		protocol : new OpenLayers.Protocol.HTTP({
			// "HelloKml.kml"
			url : "HelloKml.kml",
			format : new OpenLayers.Format.KML({
				extractStyles : true,
				extractAttributes : true,
				maxDepth : 2
			})
		})
	});
	console.log(kml);

	// add all the layers to the map.
	map.addLayers([gmap, features, kml]);

	// CONTROLS
	// External Editing toolbar
	var container = document.getElementById("controlPanel");
	var panel = new OpenLayers.Control.EditingToolbar(features);
	map.addControl(panel);

	// add control to select the features in the vector layer
	var sf = new OpenLayers.Control.SelectFeature(kml, {
		multiple : false,
		toggle : false,
		box : true,
		onSelect : onFeatureSelect,
		onUnselect : onFeatureUnselect
	});
	map.addControl(sf);
	sf.activate();

	// mousewheel navigation and documentDrag
	map.addControl(new OpenLayers.Control.Navigation({
		documentDrag : true
	}));

	// Google.v3 uses EPSG:900913 as projection, so we have to
	// transform our coordinates
	map.setCenter(new OpenLayers.LonLat(-157.9755, 21.49).transform(new OpenLayers.Projection("EPSG:4326"), map.getProjectionObject()), 10);
}

function onFeatureSelect(feature) {
	selectedFeature = feature;
	popup = new OpenLayers.Popup.FramedCloud("chicken", feature.geometry.getBounds().getCenterLonLat(), null, 
	  "<div style='font-size:.8em'>Description: " + feature.attributes.description + "</div>", null, true, null);
	for (object in feature.attributes) {
		alert(object);
	}
	feature.popup = popup;
	map.addPopup(popup);
}

function onFeatureUnselect(feature) {
	map.removePopup(feature.popup);
	feature.popup.destroy();
	feature.popup = null;
}