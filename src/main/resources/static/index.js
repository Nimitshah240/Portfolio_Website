// element toggle function
const elementToggleFunc = function (elem) { elem.classList.toggle("active"); }

let projectData;
let skills;

// sidebar variables
const sidebar = document.querySelector("[data-sidebar]");
const sidebarBtn = document.querySelector("[data-sidebar-btn]");

// sidebar toggle functionality for mobile
sidebarBtn.addEventListener("click", function () { elementToggleFunc(sidebar); });

// Developer - Nimit Shah
// Version - v0.0.0 - Beta
// Developed on - 14/04/2025
// Description - Use to set click for navbar.
// Updated on - -
// Updated Version - -
// Input - none
try {
  // page navigation variables
  const navigationLinks = document.querySelectorAll("[data-nav-link]");
  const pages = document.querySelectorAll("[data-page]");


  // add event to all nav link
  for (let i = 0; i < navigationLinks.length; i++) {
    navigationLinks[i].addEventListener("click", function () {

      for (let i = 0; i < pages.length; i++) {
        if (this.innerHTML.toLowerCase() === pages[i].dataset.page) {
          pages[i].classList.add("active");
          navigationLinks[i].classList.add("active");
          window.scrollTo(0, 0);
        } else {
          pages[i].classList.remove("active");
          navigationLinks[i].classList.remove("active");
        }
      }

    });
  }
} catch (error) {
  console.error(error);
}


// Developer - Nimit Shah
// Version - v0.0.0 - Beta
// Developed on - 14/04/2025
// Description - Use to calculate time period of any experience.
// Updated on - -
// Updated Version - -
// Input - none
// experience-calculator.js
document.addEventListener("DOMContentLoaded", () => {
  function calculateDuration(startDate, endDate) {
    const start = new Date(startDate)
    const end = endDate === "present" ? new Date() : new Date(endDate)
    const diffTime = Math.abs(end - start)
    const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24))

    const years = Math.floor(diffDays / 365)
    const months = Math.floor((diffDays % 365) / 30)

    let duration = ""
    if (years > 0) {
      duration += `${years} yr${years > 1 ? "s" : ""}`
    }
    if (months > 0) {
      if (duration) duration += ", "
      duration += `${months} mo${months > 1 ? "s" : ""}`
    }
    return duration
  }

  function updateDurations() {
    const timelineItems = document.querySelectorAll(".timeline-item span[data-start-date]")
    timelineItems.forEach((item) => {
      const startDate = item.getAttribute("data-start-date")
      const endDate = item.getAttribute("data-end-date")
      const durationElement = item.querySelector(".duration")

      if (durationElement) {
        const duration = calculateDuration(startDate, endDate)
        durationElement.textContent = duration
      } else if (endDate === "present") {
        const duration = calculateDuration(startDate, "present")
        item.textContent = `${item.textContent.split("—")[0]}— Present • ${duration}`
      }
    })
  }

  // Initial update
  updateDurations()

  // Update durations every minute
  setInterval(updateDurations, 60000)
})

// Developer - Nimit Shah
// Version - v0.0.0 - Beta
// Developed on - 14/04/2025
// Description - Use to show toast when it is required
// Updated on - -
// Updated Version - -
// Input - message and isSuccess
function showToast(message, isSuccess) {
  toast.innerHTML = `
          <div class="toast__icon">
              <svg fill="none" height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg">
                  <path d="m13 13h-2v-6h2zm0 4h-2v-2h2zm-1-15c-1.3132 0-2.61358.25866-3.82683.7612-1.21326.50255-2.31565 1.23915-3.24424 2.16773-1.87536 1.87537-2.92893 4.41891-2.92893 7.07107 0 2.6522 1.05357 5.1957 2.92893 7.0711.92859.9286 2.03098 1.6651 3.24424 2.1677 1.21325.5025 2.51363.7612 3.82683.7612 2.6522 0 5.1957-1.0536 7.0711-2.9289 1.8753-1.8754 2.9289-4.4189 2.9289-7.0711 0-1.3132-.2587-2.61358-.7612-3.82683-.5026-1.21326-1.2391-2.31565-2.1677-3.24424-.9286-.92858-2.031-1.66518-3.2443-2.16773-1.2132-.50254-2.5136-.7612-3.8268-.7612z" fill="#fff"></path>
              </svg>
          </div>
          <div class="toast__title">${message}</div>
          <div class="toast__close">
              <svg height="20" viewBox="0 0 20 20" width="20" xmlns="http://www.w3.org/2000/svg">
                  <path d="m15.8333 5.34166-1.175-1.175-4.6583 4.65834-4.65833-4.65834-1.175 1.175 4.65833 4.65834-4.65833 4.6583 1.175 1.175 4.65833-4.6583 4.6583 4.6583 1.175-1.175-4.6583-4.6583z" fill="#fff"></path>
              </svg>
          </div>`;

  toast.className = `toast ${isSuccess ? "success" : "error"} show`

  setTimeout(() => {
    toast.className = "toast"
  }, 3000)

  const closeBtn = toast.querySelector(".toast__close")
  closeBtn.addEventListener("click", () => {
    toast.className = "toast"
  })
}

// Developer - Nimit Shah
// Version - v0.0.0 - Beta
// Developed on - 14/04/2025
// Description - Use to open any project to show it's details
// Updated on - -
// Updated Version - -
// Input - event.target.id
function openProject(event) {
  try {
    document.getElementById('spinners').style.display = 'flex';
    document.getElementById('spinner-content').innerText = 'Loading Project ...'
    let link = '';

    JSON.parse(sessionStorage.getItem('project')).forEach(element => {
      if (element.id == event.target.id) {

        document.getElementById('logo').innerHTML += `<img src="data:image/png+jpg;base64,${element.logo}" alt="client logo" class="project-logo">`;
        document.getElementById('project-title').textContent = element.name;
        document.getElementById('project-description').textContent = element.description;
        let a = JSON.stringify(element.link);

        const obj = Object.fromEntries(
          a.slice(1, -1).split(/,\s*/).map(s => s.split('='))
        );

        for (const key in obj) {
          if (obj.hasOwnProperty(key)) {
            link += `<p class="link"><b>${key} :</b>
                    <a href="${obj[key]}" target="_blank" class="project-link">
                        ${obj[key]}
                        <ion-icon name="link-outline"></ion-icon>
                    </a>
                </p>`;
          }
        }
        let tool = '';
        document.getElementById('link-section').innerHTML = link;
        let toolUsed = element.tools.split(',');
        for (const tl of toolUsed) {
          skills.forEach(el => {
            if (tl.toLowerCase() == el.name.toLowerCase()) {
              tool += `<li class=" clients-item-n">
                      <img src="data:image/svg+xml;base64,${el.image}" alt="client logo" class="technology">
                  </li>`;
            }
          });
        }
        document.getElementById('project-technology').innerHTML = tool;

        fetch(`http://localhost:8080/api/project_image/${event.target.id}`)
          .then(response => response.json())
          .then(projectimages => {
            let project_image = '';
            try {
              projectimages.forEach(element => {
                const blob = base64ToBlob(element.image);
                const BlobUrl = URL.createObjectURL(blob);
                project_image += `<li>
                                    <a href="${BlobUrl}" target="_blank">
                                      <img src="${BlobUrl}" alt="client logo" class="project-image">
                                    </a>
                                  </li>`;
              });
              document.getElementById('project-image').innerHTML = project_image
              document.getElementById('spinners').style.display = 'none';

            } catch (error) {
              document.getElementById('spinners').style.display = 'none';
              console.error(error);
            }
          });

      }
    });

    Array.from(document.getElementsByClassName('info_more-btn')).forEach(element => {
      element.style.zIndex = "0";
    });
    Array.from(document.getElementsByClassName('background-divider')).forEach(element => {
      element.style.display = "flex";
    });
    Array.from(document.getElementsByClassName('navbar')).forEach(element => {
      element.style.zIndex = "1";
    });

  } catch (error) {
    console.error(error);
  }
}

// Developer - Nimit Shah
// Version - v0.0.0 - Beta
// Developed on - 14/04/2025
// Description - Use to close the project details.
// Updated on - -
// Updated Version - -
// Input - none
function closeProject() {
  try {

    document.getElementById('project-title').textContent = '';
    document.getElementById('project-description').textContent = '';
    document.getElementById('link-section').innerHTML = '';
    document.getElementById('logo').innerHTML = '';

    Array.from(document.getElementsByClassName('info_more-btn')).forEach(element => {
      element.style.zIndex = "0";
    });
    Array.from(document.getElementsByClassName('background-divider')).forEach(element => {
      element.style.display = "none";
    });
    Array.from(document.getElementsByClassName('navbar')).forEach(element => {
      element.style.zIndex = "2";
    });

  } catch (error) {
    console.error(error);
  }
}

// Developer - Nimit Shah
// Version - v0.0.0 - Beta
// Developed on - 14/04/2025
// Description - Use to save contact form in the database.
// Updated on - -
// Updated Version - -
// Input - none
function saveContact() {

  document.getElementById('spinners').style.display = 'flex';
  document.getElementById('spinner-content').innerText = 'Sending Message ...';

  let data = {
    id: new Date().getTime().toString(),
    name: `${document.getElementById('contact-name').value}`,
    email: `${document.getElementById('contact-email').value}`,
    message: `${document.getElementById('contact-message').value}`,
    subject: `${document.getElementById('contact-subject').value}`
  };

  fetch("http://localhost:8080/api/saveContact", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(data)
  })
    .then(res => res.json())
    .then(result => {
      document.getElementById('contact-name').value = '';
      document.getElementById('contact-email').value = '';
      document.getElementById('contact-subject').value = '';
      document.getElementById('contact-message').value = '';
      showToast('Thank you, We recieved your message', 'success');
      document.getElementById('spinners').style.display = 'none';

    }).catch(err => {
      console.error("Error:", err)
      document.getElementById('spinners').style.display = 'none';
    });
}

// Developer - Nimit Shah
// Version - v0.0.0 - Beta
// Developed on - 14/04/2025
// Description - Use to get personal information as well as all the details.
// Updated on - -
// Updated Version - -
// Input - none
function getPersonaldetails() {
  try {
    document.getElementById('spinners').style.display = 'flex';
    document.getElementById('spinner-content').innerText = 'Loading Nimit Shah ...';
    if (sessionStorage.getItem('personaldetails') == null) {
      fetch('http://localhost:8080/api/personaldetails')
        .then(response => response.json())
        .then(data => {
          setPersonalDetails(data);
          sessionStorage.setItem('personaldetails', JSON.stringify(data));
        })
        .catch(error => {
          showToast('Server error, please try again later.', 'error');
          document.getElementById('spinners').style.display = 'none';
        });
    } else {
      setPersonalDetails(JSON.parse(sessionStorage.getItem('personaldetails')));
    }

    getSkills();
    getCertificate();
    getProject();

  } catch (error) {
    showToast('Failed to get data', 'error')
    document.getElementById('spinners').style.display = 'none';
  }
}

// Developer - Nimit Shah
// Version - v0.0.0 - Beta
// Developed on - 14/04/2025
// Description - Use to render personal details on the page.
// Updated on - -
// Updated Version - -
// Input - none
function setPersonalDetails(data) {
  try {
    // To set name from properties file
    document.getElementById('name').textContent = data.name;

    document.getElementById('developer').textContent = data.developer;

    // To set email from properties file
    const email = document.getElementById('email');
    email.setAttribute("href", "mailto:" + data.email);
    email.textContent = data.email;

    // To set phone from properties file
    const phone = document.getElementById('phone');
    phone.setAttribute("href", "tel:" + data.phone)
    phone.textContent = data.phone;

    // To set description from properties file
    document.getElementById('description').innerHTML = data.aboutme;

    // To set linkedin from properties file
    document.getElementById('linkedin').setAttribute("href", data.linkedin)

    // To set whatsapp from properties file
    document.getElementById('whatsapp').setAttribute("href", data.whatsapp)

    // To set instagram from properties file
    document.getElementById('instagram').setAttribute("href", data.instagram)

    // To set github from properties file
    document.getElementById('github').setAttribute("href", data.github)

    // To set location from properties file
    document.getElementById('location').textContent = data.location


  } catch (error) {
    console.error(error);
  }

}

// Developer - Nimit Shah
// Version - v0.0.0 - Beta
// Developed on - 14/04/2025
// Description - Use to get skills.
// Updated on - -
// Updated Version - -
// Input - none
function getSkills() {
  try {
    if (sessionStorage.getItem('skills') == null) {
      fetch("http://localhost:8080/api/skill")
        .then(response => response.json())
        .then(data => {
          sessionStorage.setItem('skills', JSON.stringify(data));
          skills = data;
          setSkills();
        });
    } else {
      skills = JSON.parse(sessionStorage.getItem('skills'));
      setSkills();
    }
  } catch (error) {
    document.getElementById('spinners').style.display = 'none';
    showToast('Failed to get skills', 'error')
  }
}

// Developer - Nimit Shah
// Version - v0.0.0 - Beta
// Developed on - 14/04/2025
// Description - Use to render skills on the page.
// Updated on - -
// Updated Version - -
// Input - none
function setSkills() {
  try {
    const skill = document.getElementById("skill");
    let html = "";
    skills.forEach(element => {
      html += `
      <li class="clients-item-n">
            <img src="data:image/svg+xml;base64,${element.image}" alt="client logo" class="project-image">
            <h1 class="project-title">${element.name}</h1>
      </li>`
    });

    skill.innerHTML = html;
    document.getElementById('spinners').style.display = 'none';
  } catch (error) {
    document.getElementById('spinners').style.display = 'none';

  }
}

// Developer - Nimit Shah
// Version - v0.0.0 - Beta
// Developed on - 14/04/2025
// Description - Use to get certificates.
// Updated on - -
// Updated Version - -
// Input - none
function getCertificate() {
  try {
    if (sessionStorage.getItem('certificate') == null) {
      fetch("http://localhost:8080/api/certificate")
        .then(response => response.json())
        .then(data => {
          sessionStorage.setItem('certificate', JSON.stringify(data));
          setCertificate(data);
        });
    } else {
      setCertificate(JSON.parse(sessionStorage.getItem('certificate')));
    }
  } catch (error) {
    showToast('Failed to get certificate', 'error')
    console.error(error);

  }
}

// Developer - Nimit Shah
// Version - v0.0.0 - Beta
// Developed on - 14/04/2025
// Description - Use to render certificates on the page.
// Updated on - -
// Updated Version - -
// Input - none
function setCertificate(data) {
  try {
    const container = document.getElementById("certificate");
    data.forEach((item, index) => {
      const blob = base64ToBlob(item.file);
      const pdfBlobUrl = URL.createObjectURL(blob);
      if (item.name != "CV") {

        const li = document.createElement("li");
        li.className = "clients-item-n";

        const canvas = document.createElement("canvas");
        canvas.className = "project-image certi";
        canvas.id = `pdf-canvas-${index}`;

        const title = document.createElement("h1");
        title.className = "project-title";
        title.innerText = item.name;

        const year = document.createElement("h3");
        year.className = "project-category";
        year.innerText = item.year;

        li.appendChild(canvas);
        li.appendChild(title);
        li.appendChild(year);
        container.appendChild(li);

        // Render thumbnail
        const loadingTask = pdfjsLib.getDocument(pdfBlobUrl);
        loadingTask.promise.then(pdf => {
          pdf.getPage(1).then(page => {
            const scale = 0.5;
            const viewport = page.getViewport({ scale });

            canvas.width = viewport.width;
            canvas.height = viewport.height;

            const context = canvas.getContext("2d");
            const renderContext = {
              canvasContext: context,
              viewport: viewport
            };

            page.render(renderContext);
          });
        });
        canvas.addEventListener("click", () => {
          window.open(pdfBlobUrl, "_blank");
        });
      } else {
        document.getElementById("cv-icon").addEventListener("click", () => {
          window.open(pdfBlobUrl, "_blank");
        });
      }
    });
  } catch (error) {
    showToast('Error while setting certificate', 'error');
  }
}

// Developer - Nimit Shah
// Version - v0.0.0 - Beta
// Developed on - 14/04/2025
// Description - Use to convert base64 to blob.
// Updated on - -
// Updated Version - -
// Input - none
function base64ToBlob(base64) {
  try {
    const mime = detectMimeTypeFromBase64(base64)

    const byteChars = atob(base64);
    const byteNumbers = new Array(byteChars.length);
    for (let i = 0; i < byteChars.length; i++) {
      byteNumbers[i] = byteChars.charCodeAt(i);
    }
    const byteArray = new Uint8Array(byteNumbers);
    return new Blob([byteArray], { type: mime });
  } catch (error) {
    console.error(error);

  }
}

// Developer - Nimit Shah
// Version - v0.0.0 - Beta
// Developed on - 14/04/2025
// Description - Use to detect mime type of the base64.
// Updated on - -
// Updated Version - -
// Input - none
function detectMimeTypeFromBase64(base64) {
  const firstBytes = atob(base64).slice(0, 4);
  if (firstBytes.startsWith('%PDF')) return 'application/pdf';
  if (firstBytes.charCodeAt(0) === 0x89) return 'image/png';
  if (firstBytes.charCodeAt(0) === 0xFF) return 'image/jpeg';
  return 'application/octet-stream'; // fallback
}

// Developer - Nimit Shah
// Version - v0.0.0 - Beta
// Developed on - 14/04/2025
// Description - Use to get Project.
// Updated on - -
// Updated Version - -
// Input - none
function getProject() {
  try {
    if (sessionStorage.getItem('project') == null) {
      fetch("http://localhost:8080/api/project")
        .then(response => response.json())
        .then(data => {
          setProject(data);
          sessionStorage.setItem('project', JSON.stringify(data));
          projectData = data;
        });
    } else {
      setProject(JSON.parse(sessionStorage.getItem('project')));
    }
  } catch (error) {
    console.error(error);
  }
}

// Developer - Nimit Shah
// Version - v0.0.0 - Beta
// Developed on - 14/04/2025
// Description - Use to render Project on the page.
// Updated on - -
// Updated Version - -
// Input - none
function setProject(data) {
  try {
    let html = '';
    data.forEach(element => {
      html += `
            <li class="project-item  active"id="${element.id}" data-filter-item data-category="applications">
              <button onclick="openProject(event)" id="${element.id}" target="_blank">
                <figure class="project-img"  id="${element.id}">
                  <div class="project-item-icon-box" id="${element.id}">
                    <ion-icon name="information-circle-outline" id="${element.id}"></ion-icon>
                  </div>
                  <img src="data:image/png;base64,${element.logo}" alt="${element.name}" loading="lazy">
                </figure>
                <h3 class="project-title" id="${element.id}">${element.name}</h3>
              </button>
            </li>`
    });
    const project = document.getElementById("project");
    project.innerHTML = html;
  } catch (error) {
    console.error(error);
  }
}