console.log("made it");

window.addEventListener('load', function(e) {
	console.log('document loaded');
	init();
});

function init() {
	document.bucketForm.lookup.addEventListener('click', function(event) {
		event.preventDefault();
		var bucketId = document.bucketForm.bucketId.value;
		if (!isNaN(bucketId) && bucketId > 0) {
			getOneBucket(bucketId);
		}
	});
	document.getElementById('allBuckets').addEventListener('click', function() {
		event.preventDefault();

		console.log('click');
		listAllBuckets();
	});
	document.addBucket.submit.addEventListener('click', function() {
		event.preventDefault();
		console.log('click');
		postBucket();
	});
}

function getOneBucket(id) {
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/bucket/' + id, true);

	xhr.onreadystatechange = function() {
		let err = document.getElementById('bucketData')
		let header = document.createElement('h2');
		if (xhr.readyState === 4 && xhr.status < 400) {
			var obj = JSON.parse(xhr.responseText);
			console.log(obj);
			displayBucket(obj);
		}

		if (xhr.readyState === 4 && xhr.status >= 400) {
			header.textContent = 'Bucket not found';
			err.appendChild(header);
		}
	};
	xhr.send(null);
}

function displayBucket(obj) {
	let fields = Object.keys(obj);
    document.updateForm.innerHTML = '';
    fields.forEach(function(val, index, array) {
        let input = document.createElement('input')
        input.name = val; 
        input.type = 'text';
        document.updateForm.appendChild(input);
        input.insertAdjacentHTML("beforeBegin",val.toString() + ": ");
        input.insertAdjacentHTML("afterend","<br>");
        document.updateForm.elements[index].value = obj[val];
    });
    
    let input = document.createElement('input')
    input.name = 'submit'; 
    input.type = 'submit';
    input.value = 'Update';
    document.updateForm.appendChild(input);
    document.updateForm.submit.addEventListener('click', function(e){
    	e.preventDefault();
    	var id = obj.id;
    	updateBucket(id);
    });

	var dataDiv = document.getElementById('bucketData');
	dataDiv.textContent = '';

	var h2 = document.createElement('h2');
	var ul = document.createElement('ul');
	var li = document.createElement('li');
	var li1 = document.createElement('li');
	var li2 = document.createElement('li');
	var li3 = document.createElement('li');
	var block = document.createElement('blockquote');

	h2.textContent = obj.activity;
	dataDiv.appendChild(h2);

	block.textContent = obj.desc;
	dataDiv.appendChild(block);

	li.textContent = obj.levelHate;
	ul.appendChild(li);

	li1.textContent = obj.active;
	ul.appendChild(li1);

	li2.textContent = obj.howHappened;
	ul.appendChild(li2);

	li3.textContent = obj.howExperience;
	ul.appendChild(li3);

	dataDiv.appendChild(ul);

	let form = document.createElement('form');
	form.name = 'deleteForm';
	dataDiv.appendChild(form);
	let input2 = document.createElement('input');
	input2.type = 'submit';
	input2.name = 'submit';
	input2.value = 'Delete Bucket';
	form.appendChild(input2);

	document.deleteForm.addEventListener('submit', function(e) {
		clearPage();
		e.preventDefault();
		deleteBucket(obj.id);
	});
	
//	let uForm = document.createElement('form');
//	uForm.name = 'updateForm';
//	dataDiv.appendChild(form);
//	let inputUpdate = document.createElement('input');
//	inputUpdate.type = 'submit';
//	inputUpdate.name = 'submit';
//	inputUpdate.value = 'Update Bucket';
//	form.appendChild(input);
//	
//	document.updateForm.addEventListener('submit', function(e) {
//		e.preventDefault();
//		updateBucket(obj.id);
//	});
}

function listAllBuckets() {
	let url = 'api/bucket';
	let xhr = new XMLHttpRequest();
	xhr.open('GET', url);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				let obj = JSON.parse(xhr.response);
				console.log("listallbuckets");
				
				console.log(obj);
				displayAll(obj);
			}
		}
	};
	xhr.send();
}

function displayAll(obj) {
	console.log("displayAll");
	let bucketDiv = document.getElementById('bucketData');
	let table = document.createElement('table');
	bucketDiv.appendChild(table);
	let hateTotal = obj.reduce((hateSum, tool) => {
		if (tool.levelHate) {
			hateSum += tool.levelHate;
		}
		return hateSum;
	}, 0);
	console.log("all my hate === " + hateTotal)
	obj.forEach(function(obj, index) {
		let tr = document.createElement('tr');
		let td = document.createElement('td');
		td.textContent = obj.activity;
		tr.appendChild(td);
		td = document.createElement('td');
		td.textContent = obj.desc;
		tr.appendChild(td);
		table.appendChild(tr);
		tr.addEventListener('click', function(evt) {
			getOneBucket(obj.id);
		});
	});
}

function postBucket() {

	console.log("in postBucket");
	let url = 'api/bucket';
	let xhr = new XMLHttpRequest();
	xhr.open('POST', url);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				console.log("in if");
				let bucket = JSON.parse(xhr.response);
				displayBucket(bucket);
			} else {
				console.log("POST request failed.");
				console.error(xhr.status + ': ' + xhr.responseText);
			}
		}
	};
	let form = document.addBucket;
	var newBucket = {
		activity : form.activity.value,
		desc : form.desc.value,
		levelHate : form.levelHate.value,
		active : form.active.value,
		howHappened : form.howHappened.value,
		howExperience : form.howExperience.value
	};
	xhr.send(JSON.stringify(newBucket));
	console.log(newBucket);
}

function deleteBucket(id) {
	var xhr = new XMLHttpRequest();
	xhr.open('DELETE', 'api/bucket/' + id, true);

	xhr.onreadystatechange = function() {
		let err = document.getElementById('bucketData');
		let header = document.createElement('h2');
		if (xhr.readyState === 4 && xhr.status < 400) {
			header.textContent = 'Bucket Deleted';
			err.appendChild(header);
		}

		if (xhr.readyState === 4 && xhr.status >= 400) {
			header.textContent = 'Bucket not found';
			err.appendChild(header);
		}
	};
	xhr.send(null);
}

function clearPage() {
	let div = document.getElementById('bucketData');
	while (div.firstElementChild) {
		div.removeChild(div.firstElementChild);
	}
}

function updateBucket(id) {
	console.log(id);
	let xhr = new XMLHttpRequest();
	xhr.open('PUT', 'api/bucket/' + id);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				console.log("in if");
				let bucket = JSON.parse(xhr.response);
				displayBucket(bucket);
			} else {
				console.log("Update request failed.");
				console.error(xhr.status + ': ' + xhr.responseText);
			}
		}
	};
	let form = document.updateForm;
	var updatedBucket = {
		activity : form.activity.value,
		desc : form.desc.value,
		levelHate : form.levelHate.value,
		active : form.active.value,
		howHappened : form.howHappened.value,
		howExperience : form.howExperience.value
	};
	xhr.send(JSON.stringify(updatedBucket));
}
