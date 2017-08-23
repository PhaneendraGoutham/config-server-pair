VAGRANTFILE_API_VERSION = "2"
ANSIBLE_INVENTORY_DIR   = '.vagrant/provisioners/ansible/inventory'

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  config.vm.box = "centos/7"

  (1..2).each do |i|
    config.vm.define "host#{i}-local" do |node|
      node.vm.hostname = "host#{i}-local"
      node.vm.network :private_network, ip: "192.168.33.#{i+1}"
      node.vm.network "forwarded_port", guest: "8080", host: "808#{i}"
    end
  end

  config.vm.provision "vai" do |ansible|
    ansible.inventory_dir=ANSIBLE_INVENTORY_DIR
  end

end